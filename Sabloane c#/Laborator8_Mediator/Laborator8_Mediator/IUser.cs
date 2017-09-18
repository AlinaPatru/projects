using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Mediator
{
    public interface IUser
    {
        string Name { get; set; }
        IChatroom Chatroom { get; set; }

        void Send(IUser user, string message);
        void Receive(IUser user, string message);

    }
}
