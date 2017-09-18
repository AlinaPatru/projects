using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Bridge
{
    class Program
    {
        static void Main(string[] args)
        {
            InstantMessenger messenger = new InstantMessenger(new WhatsAppImpl());
            messenger.SendMessage("Hello");
            messenger.SendFile("Picture");
            messenger.SendMessage("I sent you a picture");


            messenger.MessagingImpl = new FacebookMessengerImpl();
            messenger.SendMessage("Hello");
            messenger.SendFile("Document");
            messenger.SendMessage("I sent you a document");
            Console.ReadKey(true);
        }
    }
}
