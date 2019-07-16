import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpServerTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            // ���������� �����ϰ� 5000�� ��Ʈ�� ����(bind) ��Ų��.
            serverSocket = new ServerSocket(5000);
            System.out.println(getTime() + " ������ �غ�Ǿ����ϴ�.");
        } catch (IOException e) {
            e.printStackTrace();
        } // try - catch

        while (true) {
            try {
                System.out.println(getTime() + " �����û�� ��ٸ��ϴ�.");
                // ���������� Ŭ���̾�Ʈ�� �����û�� �� ������ ������ ���߰� ��� ��ٸ���.
                // Ŭ���̾�Ʈ�� �����û�� ���� Ŭ���̾�Ʈ ���ϰ� ����� ���ο� ������ �����Ѵ�.
                Socket socket = serverSocket.accept();
                System.out.println(getTime() + socket.getInetAddress() + " �κ��� �����û�� ���Խ��ϴ�.");

                // ������ ��½�Ʈ���� ��´�.
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out); // �⺻�� ������ ó���ϴ� ������Ʈ��

                // ���� ����(remote socket)�� �����͸� ������.
                dos.writeUTF("�����κ����� �޼����Դϴ�.");
                System.out.println(getTime() + " �����͸� �����߽��ϴ�.");

                // ��Ʈ���� ������ �޾��ش�.
                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } // try - catch
        } // while
    } // main

    static String getTime() {
        SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    } // getTime
} // TcpServerTest

