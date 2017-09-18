using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Composite
{
    class Leaf : Vegetation
    {
        public Leaf(string name, string parentName)
            : base(name, parentName)
        {

        }

        public override void Add(Vegetation vegetation)
        {

        }

        public override void Remove(Vegetation vegetation)
        {

        }

        public override void Display(int depth)
        {
            Console.WriteLine(new String('*', depth) + name + " from " + parentName);
        }
    }
}
