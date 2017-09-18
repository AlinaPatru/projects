using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Adapter
{
    public class CylindricalObjectAdapter
    {
        private RectangularSocket socket=new RectangularSocket();

        public string GetPowerSupply(string firstWire, string secondWire)
        {
            return string.Format("{0} {1}", EAdapterType.ObjectAdapter, socket.GetSupply(firstWire,secondWire));
        }
    }
}
