using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator8_Mediator
{
    public class Chatroom:IChatroom
    {
        public List<IUser> _users;

        public Chatroom()
        {
            _users = new List<IUser>();
        }

        public bool Register(IUser user)
        {
            if (_users.Contains(user))
                return false;
            Console.WriteLine(user.Name + " a intrat in chat");
            user.Chatroom = this;
            _users.Add(user);
            return true;

        }

        public bool UnRegister(IUser user)
        {
            if (_users.Contains(user))
            {
                Console.WriteLine(user.Name + " a parasit chat-ul!");
                _users.Remove(user);
                return true;
            }
            return false;
        }

        public void Send(string message, IUser user1, IUser user2)
        {
            if(_users.Contains(user1) && _users.Contains(user2))
            {
                if(!user1.Equals(user2))
                    user2.Receive(user1, message);
            }
            else
            {
                if(user2==null)
                    foreach (var user in _users)
                        if (!user1.Equals(user))
                            user.Receive(user1, message);
                
            }
        }
    }
}
