using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Mediator
{
    class Program
    {
        static void Main(string[] args)
        {
            IChatroom chatroom = new Chatroom();
            IUser user1 = new User() { Name = "Alina"};
            IUser user2 = new User() { Name = "Sorin" };
            IUser user3 = new User() { Name = "Admin"};
            IUser user4 = new User() { Name = "Mircea"};

            chatroom.Register(user3);
            chatroom.Register(user1);
            chatroom.Register(user2);
            chatroom.Register(user4);

            user1.Send(user2, "Buna Sorin");
            user2.Send(user1, "Buna Alina");

            chatroom.UnRegister(user2);

            user3.Send(null,"Mesaj de la admin");

            Console.Read();
        }
    }
}
