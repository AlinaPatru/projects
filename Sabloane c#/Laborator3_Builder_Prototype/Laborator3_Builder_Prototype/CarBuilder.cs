using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    
    public class CarBuilder : ICarBuilder
    {
        protected Car car = new Car();
        public Car GetCar()
        {
            return this.car;
        }

        public void SetColor(string color)
        {
            car.Color = color;
        }

        public void SetEngine(string engine)
        {
            car.Engine = engine;
        }

        public void SetModel(Model model)
        {
            car.Model = model;
        }
    }
    
}
