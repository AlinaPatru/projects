using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Adapter
{
    public class CylindricalClassAdapter:RectangularSocket
    {
        public string GetPowerSupply(string firstWire, string secondWire)
        {
            return string.Format("{0} {1}", EAdapterType.ClassAdapter,GetSupply(firstWire, secondWire));
        }
    }
}
