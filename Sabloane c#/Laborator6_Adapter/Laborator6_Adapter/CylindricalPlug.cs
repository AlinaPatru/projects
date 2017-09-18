using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator6_Adapter
{
    public class CylindricalPlug
    {
        private string firstWire;
        private string secondWire;

        public CylindricalPlug(string first, string second)
        {
            this.firstWire = first;
            this.secondWire = second;
        }

        public string GetPowerSupply(EAdapterType type)
        {
            switch(type)
            {
                case EAdapterType.ClassAdapter:
                    {
                        CylindricalClassAdapter adapter = new CylindricalClassAdapter();
                        return adapter.GetPowerSupply(firstWire, secondWire);
                    }
                case EAdapterType.ObjectAdapter:
                    {
                        CylindricalObjectAdapter adapter = new CylindricalObjectAdapter();
                        return adapter.GetPowerSupply(firstWire, secondWire);
                    }
            }

            return null;
        }
    }
}
