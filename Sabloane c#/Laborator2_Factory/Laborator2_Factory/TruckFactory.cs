using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    class TruckFactory : CarFactory
    {
        public override Car GetCar(BrandType brand, EngineType engine)
        {
            id++;
            return new Truck(id, brand, engine);
        }
    }
}
