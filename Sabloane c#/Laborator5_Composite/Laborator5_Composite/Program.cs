using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Laborator5_Composite
{
    class Program
    {
        static void Main(string[] args)
        {
            Vegetation tree = new Tree("root", "");
            Vegetation branch1 = new Branch("branch1", "root");
            Vegetation branch2 = new Branch("branch2", "root");
            Vegetation branch3 = new Branch("branch3", "root");

            branch1.Add(new Leaf("leaf1", "branch1"));
            branch1.Add(new Leaf("leaf2", "branch1"));
            branch2.Add(new Leaf("leaf1", "branch2"));
            branch3.Add(new Leaf("leaf1", "branch3"));
            branch3.Add(new Leaf("leaf2", "branch3"));
            branch3.Add(new Leaf("leaf3", "branch3"));

            tree.Add(branch1);
            tree.Add(branch2);
            tree.Add(branch3);

            tree.Display(1);

            Console.Read();
        }
    }
}
