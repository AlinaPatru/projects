using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    class WhatsAppImpl : IMessagingImpl
    {
        public void SendMessage(string message)
        {
            Console.WriteLine("Message   " + message + "    using WhatsApp");
        }

        public void SendFile(string fileName)
        {
            Console.WriteLine("File   " + fileName + "    using WhatsApp");
        }

        public void VoiceCall()
        {
            Console.WriteLine("Voice call using WhatsApp");
        }

        public void VideoCall()
        {
            Console.WriteLine("Video call using WhatsApp");
        }
    }
}
