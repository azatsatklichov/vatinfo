package net.sahet.vatinfo.config;

/**
 * What is WebSocket
 * 
 * Like http, websocket is also a communication protocol which provides
 * bi-directional, full-duplex communication channel between a server and
 * client.
 * 
 * Once, a WebSocket connection is established between a client and a server,
 * both the parties can exchange information endlessly until the connection is
 * closed by anyone of the parties.
 * 
 * This is the main reason why WebSocket is preferred over HTTP where the client
 * and server need to exchange information at high frequency and with low
 * latency because HTTP connection is closed once a request is served by the
 * server and there is a time constraint to open an HTTP connection again.
 * 
 * What is STOMP
 * 
 * STOMP stands for Streaming Text Oriented Messaging Protocol. As per wiki,
 * STOMP is a simple text-based protocol, designed for working with
 * message-oriented middleware (MOM).
 * 
 * Websocket Listeners and Interceptors
 * 
 * Apart from above configuration, spring boot also provides mechanism to
 * register different listeners or interceptors and this configuration can be
 * added in registerStompEndpoints()
 *
 */
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig {
//
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry config) {
//		config.enableSimpleBroker("/topic/", "/queue/");
//		config.setApplicationDestinationPrefixes("/app");
//	}
//
//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/greeting");
//		;
//	}
//
//} 