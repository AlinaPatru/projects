using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    class InstantMessenger : IInstantMessenger
    {
        public IMessagingImpl MessagingImpl { get; set; }

        public InstantMessenger(IMessagingImpl messagingImpl)
        {
            this.MessagingImpl = messagingImpl;
        }

        public void SendMessage(string message)
        {
            MessagingImpl.SendMessage(message);
        }

        public void SendFile(string fileName)
        {
            MessagingImpl.SendFile(fileName);
        }
    }
}
