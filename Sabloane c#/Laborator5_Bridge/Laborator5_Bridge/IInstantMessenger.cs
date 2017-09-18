using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    interface IInstantMessenger
    {
        void SendMessage(string message);
        void SendFile(string fileName);
    }
}
