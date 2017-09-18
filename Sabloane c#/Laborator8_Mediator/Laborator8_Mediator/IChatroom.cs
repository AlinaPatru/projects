using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Mediator
{
    public interface IChatroom
    {
        bool Register(IUser user);
        bool UnRegister(IUser user);
        void Send(string message, IUser user1, IUser user2);
    }
}
