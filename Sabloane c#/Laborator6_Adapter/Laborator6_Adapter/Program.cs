using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Adapter
{
    class Program
    {
        static void Main(string[] args)
        {
            CylindricalPlug plug = new CylindricalPlug("1","2");
            Console.WriteLine(plug.GetPowerSupply(EAdapterType.ClassAdapter));
            Console.WriteLine(plug.GetPowerSupply(EAdapterType.ObjectAdapter));

            Console.Read();

        }
    }
}
