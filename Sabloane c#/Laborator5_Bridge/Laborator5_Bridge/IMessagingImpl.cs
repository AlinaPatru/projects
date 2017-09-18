using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    interface IMessagingImpl
    {
        void SendMessage(string message);
        void SendFile(string fileName);
        void VoiceCall();
        void VideoCall();
    }
}
