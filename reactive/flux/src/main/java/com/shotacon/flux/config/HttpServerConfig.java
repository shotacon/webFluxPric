package com.shotacon.flux.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import reactor.ipc.netty.http.server.HttpServer;

/**
 * 
 * 
 * @author shota
 *
 */
@Configuration
public class HttpServerConfig {

    @Autowired
    private Environment environment;

    /**
     * 这将使用应用程序属性中定义的端口创建一个 netty HttpServer.
     * </p>
     * Spring 支持的其他服务器也跟 Tomcat 和 undertow 一样.由于 netty 是异步的, 而且天生基于事件驱动,
     * 因此更适合响应式的应用程序.
     * </p>
     * Tomcat 使用 Java NIO 来实现 servlet 规范.Netty 是 NIO 的一个实现, 它针对异步、事件驱动的非阻塞 IO
     * 应用程序进行了优化.
     * 
     * @param routerFunction
     * @return
     */
    public HttpServer httpServer(RouterFunction<?> routerFunction) {

        HttpServer httpServer = HttpServer.create("localhost", Integer.valueOf(environment.getProperty("port")));
        httpServer.newHandler(new ReactorHttpHandlerAdapter(RouterFunctions.toHttpHandler(routerFunction)));
        return httpServer;

        // Tomcat tomcatServer = new Tomcat();
        // tomcatServer.setHostname("localhost");
        // tomcatServer.setPort(Integer.valueOf(environment.getProperty("server.port")));
        // Context rootContext = tomcatServer.addContext("",
        // System.getProperty("java.io.tmpdir"));
        // ServletHttpHandlerAdapter servlet = new
        // ServletHttpHandlerAdapter(httpHandler);
        // Tomcat.addServlet(rootContext, "httpHandlerServlet", servlet);
        // rootContext.addServletMapping("/", "httpHandlerServlet");
        // tomcatServer.start();
    }
}
