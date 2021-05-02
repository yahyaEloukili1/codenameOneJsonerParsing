/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Statics;
import com.mycompany.myapp.entities.Task;
/**
 *
 * @author T440
 */
public class TaskService {
    public boolean resultOk;
    public boolean addTask(Task t){
        //+"/tasks/"+t.getName()+"/"+t.getStatus()
        String url = "https://jsonplaceholder.typicode.com/posts";
        ConnectionRequest req = new ConnectionRequest(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = ((req.getResponseCode() == 200) || (req.getResponseCode()== 201));
            }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
    }
}
