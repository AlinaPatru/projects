using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator2_Factory
{
    class Truck : Car
    {
        public Truck(int id, BrandType brand, EngineType engine): base(id, brand, engine)
        {

        }

        public override CarType GetCarType()
        {
            return CarType.Truck;
        }
    }
}
