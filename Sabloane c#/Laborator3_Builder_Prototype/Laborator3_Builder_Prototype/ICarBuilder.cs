using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    public interface ICarBuilder
    {
        void SetColor(string color);
        void SetModel(Model model);
        void SetEngine(string engine);

        Car GetCar();
    }
}
