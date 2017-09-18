using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public class LaureateDecorator : AmbianceDecorator
    {
        public LaureateDecorator(ICar car): base(car)
        {
            car.Type = ECarType.Laureate;
        }

        public override void Assemble()
        {
            base.Assemble();
            SetAccessory(EAccessoriesType.AccesType, "Sistem incalzire", 250);
            SetAccessory(EAccessoriesType.AmbianceType, "Sistem incalzire", 350);
            SetAccessory(EAccessoriesType.LaureateType, "Sistem incalzire", 400);


        }
    }
}
