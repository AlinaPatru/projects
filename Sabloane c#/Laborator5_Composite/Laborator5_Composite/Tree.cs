using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Composite
{
    class Tree : Branch
    {
        public Tree(string name, string parentName): base(name, parentName)
        {

        }

        public override void Display(int depth)
        {
            Console.WriteLine("Tree");
            base.Display(depth);
        }
    }
}
