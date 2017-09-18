using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    public interface ICarPrototype
    {
        Car Clone();
        bool IsClone { get; set; }
    }
}
