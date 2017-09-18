using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    class CarBuildDirector
    {
        private ICarBuilder CarBuilder { get; set; }
        public CarBuildDirector(ICarBuilder carBuilder)
        {
            this.CarBuilder = carBuilder;
        }
        public void Construct(Model model)
        {
            CarBuilder.SetColor("Albastru");
            CarBuilder.SetModel(model);
            CarBuilder.SetEngine("Gas");

        }
        public Car GetResult()
        {
            return this.CarBuilder.GetCar();
        }
    }
}
