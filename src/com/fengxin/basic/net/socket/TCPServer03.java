package com.fengxin.basic.net.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author FENGXIN
 * 服务器端
 **/
public class TCPServer03 {
    public static void main (String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket (8888);
        Socket socket = serverSocket.accept ();
        
        // 接收客户端发送的数据
        // 获取输入流
        InputStream inputStream = socket.getInputStream ();
        // 使用转换流包装数据
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (inputStream));
        String line;
        // 读取数据并输出在控制台
        while ((line = bufferedReader.readLine ()) != null){
            System.out.println (line);
        }
        
        // 服务器端发送数据给客户端
        OutputStream outputStream = socket.getOutputStream ();
        // 使用转换流包装数据
        BufferedWriter bufferedWriter = new BufferedWriter (new OutputStreamWriter (outputStream));
        bufferedWriter.write ("Hello, Client!");
        // 刷新缓存，将数据写入到输出流
        bufferedWriter.flush ();
        // 结束标志
        socket.shutdownOutput ();
        
        // 关闭资源
        bufferedWriter.close ();
        bufferedReader.close ();
        socket.close ();
        // 关闭ServerSocket对象
        serverSocket.close ();
    }
}
