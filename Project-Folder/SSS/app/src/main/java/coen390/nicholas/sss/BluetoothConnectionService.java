package coen390.nicholas.sss;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.UUID;


public class BluetoothConnectionService {
    //Defining TAGs
    private static final String TAG ="BluetoothConnectionService";
    //UUID for the application
    private static final UUID MY_UUID_INSECURE =
            UUID.fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
   // Name for the SDP record when creating server socket
    private static final String NAME_SECURE = "BluetoothSign-See-Sound";
   // defining members
   private final BluetoothAdapter mBluetoothAdapter;
    Context mContext;

    public BluetoothConnectionService(Context Context) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mContext = Context;
    }

    private class AcceptThread extends Thread {
        private final BluetoothServerSocket mmServerSocket;

        @SuppressLint("LongLogTag")
        public AcceptThread() {
            // Use a temporary object that is later assigned to mmServerSocket
            // because mmServerSocket is final.
            BluetoothServerSocket tmp = null;
            try {
                // MY_UUID is the app's UUID string, also used by the client code.
                tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord(NAME_SECURE, MY_UUID_INSECURE);
                Log.d(TAG,"Accept thread is using "+MY_UUID_INSECURE);
            } catch (IOException e) {
                Log.e(TAG, "Socket's listen() method failed"+ e.getMessage());
            }
            mmServerSocket = tmp;
        }

        public void run() {
            BluetoothSocket socket = null;
            // Keep listening until exception occurs or a socket is returned.
            while (true) {
                try {
                    socket = mmServerSocket.accept();
                } catch (IOException e) {
                    Log.e(TAG, "Socket's accept() method failed", e);
                    break;
                }

                if (socket != null) {
                    // A connection was accepted. Perform work associated with
                    // the connection in a separate thread.
                    manageMyConnectedSocket(socket);
                    mmServerSocket.close();
                    break;
                }
            }
        }

        // Closes the connect socket and causes the thread to finish.
        public void cancel() {
            try {
                mmServerSocket.close();
            } catch (IOException e) {
                Log.e(TAG, "Could not close the connect socket", e);
            }
        }
    }
}
