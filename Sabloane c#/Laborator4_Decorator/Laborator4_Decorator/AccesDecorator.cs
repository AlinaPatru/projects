using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public class AccesDecorator : CarDecorator
    {
        public AccesDecorator(ICar car): base(car)
        {
            car.Type = ECarType.Acces;
        }

        public override void Assemble()
        {
            base.Assemble();
            SetAccessory(EAccessoriesType.AccesType, "Sistem incalzire", 200);
            SetAccessory(EAccessoriesType.AmbianceType, "Sistem incalzire", 300);
            SetAccessory(EAccessoriesType.LaureateType, "Sistem incalzire", 200);
        }
    }
}
