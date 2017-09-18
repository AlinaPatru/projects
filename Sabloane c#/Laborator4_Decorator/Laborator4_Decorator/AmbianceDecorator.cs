using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator4_Decorator
{
    public class AmbianceDecorator : AccesDecorator
    {
        public AmbianceDecorator(ICar car): base(car)
        {
            car.Type = ECarType.Ambiance;
        }

        public override void Assemble()
        {
            base.Assemble();
            SetAccessory(EAccessoriesType.AccesType, "Sistem incalzire", 200);
            SetAccessory(EAccessoriesType.AmbianceType, "Sistem incalzire", 400);
            SetAccessory(EAccessoriesType.LaureateType, "Sistem incalzire", 400);

        }
    }
}
