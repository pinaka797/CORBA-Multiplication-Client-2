package AdditionApp;


/**
* AdditionApp/AdditionPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Addition.idl
* Tuesday, April 7, 2015 11:04:19 PM IST
*/

public abstract class AdditionPOA extends org.omg.PortableServer.Servant
 implements AdditionApp.AdditionOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("otherClientStatus", new java.lang.Integer (1));
    _methods.put ("shutdown", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // AdditionApp/Addition/add
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // AdditionApp/Addition/otherClientStatus
       {
         String $result = null;
         $result = this.otherClientStatus ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // AdditionApp/Addition/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:AdditionApp/Addition:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Addition _this() 
  {
    return AdditionHelper.narrow(
    super._this_object());
  }

  public Addition _this(org.omg.CORBA.ORB orb) 
  {
    return AdditionHelper.narrow(
    super._this_object(orb));
  }


} // class AdditionPOA
