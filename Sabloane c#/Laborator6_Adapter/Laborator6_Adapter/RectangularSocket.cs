using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Adapter
{
    public class RectangularSocket
    {
        public string GetSupply(string firstWire, string secondWire)
        {
            return string.Format("Rectangular socket {0} {1}", firstWire, secondWire);
        }
    }
}
