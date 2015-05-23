/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import AdditionApp.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author ajit
 */
public class StartClient {
    public static void main(String args[]){
    
        try{
    ORB orb=ORB.init(args, null);
    org.omg.CORBA.Object objref=orb.resolve_initial_references("NameService");
    NamingContextExt ncref=NamingContextExtHelper.narrow(objref);
    Addition updobj=(Addition)AdditionHelper.narrow(ncref.resolve_str("ABC"));
    System.out.println("Welcome to the Update system....");
    System.out.println("Here we see the calls made by the other client.....");
    for(;;){
        Thread.sleep(4000);
        String str=updobj.otherClientStatus();
        if(!str.equals(" "))
        System.out.println(str);
    }
        }
        catch(Exception e){
    System.err.println("Error:"+e);
    e.printStackTrace(System.out);
    }
    }    
}
