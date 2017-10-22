package com.model.computer;

import com.model.device.Device;
import com.model.device.impl.Keyboard;
import com.model.device.impl.MP3;
import com.model.device.impl.Mouse;

public class Computer {
	private Device usb;
    public void setUsb(Device device){
    	usb=device;
    }
    public void run(){
    	usb.use();
    }
    public static void main(String args[]){
    	//�����豸
    	Computer pc=new Computer();
    	Mouse mouse=new Mouse();
    	Keyboard keyboard=new Keyboard();
    	MP3 mp3=new MP3();
    	//����usb�ӿ�,������ã�������������Ķ�̬�ԣ�
    	pc.setUsb(mouse);
    	pc.run();
    	pc.setUsb(keyboard);
    	pc.run();
    	pc.setUsb(mp3);
    	pc.run();
    }
}
