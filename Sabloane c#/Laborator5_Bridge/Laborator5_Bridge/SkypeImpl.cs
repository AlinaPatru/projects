using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    class SkypeImpl : IMessagingImpl
    {
        public void SendMessage(string message)
        {
            Console.WriteLine("Message    " + message + "   using Skype");
        }

        public void SendFile(string fileName)
        {
            Console.WriteLine("File   " + fileName + "    using Skype");
        }

        public void VoiceCall()
        {
            Console.WriteLine("Voice call using Skype");
        }

        public void VideoCall()
        {
            Console.WriteLine("Video call using Skype");
        }
    }
}
