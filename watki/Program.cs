using System;
using System.Threading;
using System.IO;

namespace watki
{
    class Program
    {
        static void Main(string[] args)
        {
            var watch = System.Diagnostics.Stopwatch.StartNew();
            Watki watki = new Watki();
            int n = 4;
            Thread[] threads = new Thread[n];

            threads[0] = new Thread(watki.writelines);
            threads[1] = new Thread(watki.fileRead);
            threads[2] = new Thread(watki.obliczenia);
            threads[3] = new Thread(watki.oblInne);
            
            for(int i = 0; i < n; i++){
                threads[i].Start();
            }
            for(int i = 0; i < n; i++){
                threads[i].Join();
            }
            
            watch.Stop();
            var elapsedMs = watch.ElapsedMilliseconds;
            Console.WriteLine(elapsedMs +" ms");
            Console.WriteLine("test watkow");
        }

        public class Watki{
            public void writelines(){
                lock(this){
                    Thread.Sleep(500);
                    for(int i = 0; i<10; i++){
                        Console.WriteLine("linia tekstu {0}", i);
                    }Console.WriteLine();
                }
            }

            public void fileRead(){
                lock(this){
                    Thread.Sleep(500);
                    String text = System.IO.File.ReadAllText("data.txt");
                    Console.Write(text);
                    Console.WriteLine();
                }
            }

            public void obliczenia(){
                Thread.Sleep(500);
                int x = 13548;
                int wynik = x*x*x*x;
                Console.WriteLine("obliczona wartosc potegowanie {0}", wynik);
                Console.WriteLine();
            }
            public void oblInne(){
                Thread.Sleep(500);
                int x = 13548489;
                double wynik = Math.Sqrt(Math.Sqrt(x));
                Console.WriteLine("obliczona wartosc pierwiastkowania {0}", wynik);
                Console.WriteLine();
            }
            
        }
    }
}
