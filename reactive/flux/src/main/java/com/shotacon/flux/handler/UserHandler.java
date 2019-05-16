package com.shotacon.flux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.shotacon.flux.entity.User;
import com.shotacon.flux.respository.UserRespository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 相比较于普通的编程, 这里不返回可用前阻塞线程的 User/List<User> 对象, 而只是返回一个流的引用, 流可以在后面访问
 * User/List<User>
 * 
 * @author shota
 *
 */
@Service
public class UserHandler {

	@Autowired
	private UserRespository userRespository;

	/**
	 * <p>
	 * findAllUser()返回Flux<User>;
	 * </p>
	 * <p>
	 * ServerResponse.ok().body(UserRepository.getUsers(), User.class) 可将此 Flux
	 * <User> 转换为 Mono<ServerResponse>
	 * </p>
	 * 这表明只要可用时均可发起 ServerResponse 的流
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> handleFindAllUser(ServerRequest request) {
		return ServerResponse.ok().body(Flux.fromIterable(userRespository.findAllUser()), User.class);
	}

	/**
	 * findUserById()返回一个Mono<User>, ServerResponse.ok().body(Mono.just(user),
	 * User.class) 将此 Mono<User> 转换为Mono<ServerResponse>, 这说明随时都可以发起 ServerResponse
	 * 的流.
	 * </p>
	 * 
	 * 在给定的路径变量(pathVariable)中没有找到用户时, ServerResponse.notFound().build() 返回一个
	 * Mono<ServerResponse>, 表名是一个返回 404 服务响应的流
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> handleFindUserById(ServerRequest request) {
		User user = userRespository.findUserById(request.pathVariable("id"));
		return ServerResponse.ok().body(Mono.just(user), User.class).switchIfEmpty(ServerResponse.notFound().build());
	}

	/**
	 * ServerRequest代表的是服务器端HTTP请求.
	 * 
	 * @param request
	 * @return
	 */
	public Mono<ServerResponse> handlePostUser(ServerRequest request) {
		return ServerResponse.ok().body(request.bodyToMono(User.class).flatMap(user -> {
			userRespository.saveUser(user);
			return Mono.just(userRespository.findUserById(user.getId()));
		}), User.class);
	}

	public Mono<ServerResponse> handleDeleteUser(ServerRequest request) {
		userRespository.deleteUserById(request.pathVariable("id"));
		return ServerResponse.ok().body(Mono.empty(), User.class).switchIfEmpty(ServerResponse.notFound().build());
	}
}
