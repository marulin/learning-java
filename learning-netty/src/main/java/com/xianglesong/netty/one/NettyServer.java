package com.xianglesong.netty.one;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * netty的服务器实例
 * 
 * telnet 127.0.0.1 8080 进行测试
 * 
 * @author rollin
 *
 */
public class NettyServer {
  final static int port = 8080;

  public static void main(String[] args) {
    Server server = new Server();
    server.config(port);
    server.start();
  }
}


class Server {
  ServerBootstrap bootstrap;
  InetSocketAddress localAddress;
  MyChannelHandler channelHandler = new MyChannelHandler();

  Server() {
    bootstrap =
        new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(),
            Executors.newCachedThreadPool()));
    bootstrap.setOption("reuseAddress", true);
    bootstrap.setOption("child.tcpNoDelay", true);
    bootstrap.setOption("child.soLinger", 2);
    bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
  }

  void config(int port) {
    this.localAddress = new InetSocketAddress(port);
  }

  void start() {
    bootstrap.bind(localAddress);
  }

  class MyChannelHandler extends SimpleChannelHandler {

    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
      System.out.println("Channel closed " + e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
      System.out.println("Channel connected " + e);
      Channel ch = e.getChannel();
      ChannelBuffer cb = ChannelBuffers.wrappedBuffer("success".getBytes());
      ch.write(cb);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
      try {
        System.out.println("New message " + e.toString() + " from " + ctx.getChannel());
        processMessage(e);
      } catch (Exception ex) {
        ex.printStackTrace();
        throw ex;
      }
    }

    private void processMessage(MessageEvent e) {
      Channel ch = e.getChannel();
      System.out.println("message: " + e.getMessage());
      ch.write(e.getMessage());
    }
  }
}
