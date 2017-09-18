using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    abstract class CarFactory
    {
        public static int id = 0;
        public abstract Car GetCar(BrandType brand, EngineType engine);
    }
}
