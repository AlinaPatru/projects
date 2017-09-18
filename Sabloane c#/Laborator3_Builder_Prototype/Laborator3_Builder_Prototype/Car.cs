using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator3_Builder_Prototype
{
    public class Car : ICarPrototype
    {
        public string Color { get; set; }
        public Model Model { get; set; }
        public string Engine { get; set; }
        public bool IsClone { get; set; }

        public Car()
        {
            IsClone = false;
        }

        public override string ToString()
        {

            return string.Format("Model= "+Model+" \n Engine= "+Engine+"\n Color= "+Color+" \n ");

        }

        public Car Clone()
        {
            Car clone = this.MemberwiseClone() as Car;
            clone.Color = "red";
            clone.IsClone = true;

            return clone;
        }
    }
}
