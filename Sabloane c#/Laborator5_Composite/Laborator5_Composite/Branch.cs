using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Composite
{
    class Branch : Vegetation
    {
        private List<Vegetation> children = new List<Vegetation>();

        public Branch(string name, string parentName)
            : base(name, parentName)
        {

        }

        public override void Add(Vegetation vegetation)
        {
            children.Add(vegetation);
        }

        public override void Remove(Vegetation vegetation)
        {
            children.Remove(vegetation);
        }

        public override void Display(int depth)
        {
            Console.WriteLine(new String('*', depth) + name + " from " + parentName);
            foreach (var child in children)
            {
                child.Display(depth + 1);
            }
        }
    }
}
