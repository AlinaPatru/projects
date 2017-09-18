using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Mediator
{
    public class User:IUser
    {
        public string Name{ get ; set ; }

        public IChatroom Chatroom { get; set; }

        public void Send(IUser user, string message)
        {
            Chatroom.Send(message,this,user);
        }

        public void Receive(IUser user, string message)
        {
            Console.WriteLine("*  Sender= "+user.Name+"  message=  "+message+"  Receiver= "+this.Name);
        }
    }
}
