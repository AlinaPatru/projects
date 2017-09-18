using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    class FacebookMessengerImpl : IMessagingImpl
    {
        public void SendMessage(string message)
        {
            Console.WriteLine("Message    " + message + "    using FacebookMessenger");
        }

        public void SendFile(string fileName)
        {
            Console.WriteLine("File    " + fileName + "    using FacebookMessenger");
        }

        public void VoiceCall()
        {
            Console.WriteLine("Voice call using FacebookMessenger");
        }

        public void VideoCall()
        {
            Console.WriteLine("Video call using FacebookMessenger");
        }
    }
}
