using System;
using System.Net.Http;

namespace lab2
{
    class Program
    {
        static void Main(string[] args)
        {
            load();
            Console.Read();
        }

        public static async void load(){
            Console.WriteLine("wpisz rok");
            //string year = Console.ReadLine();
            int year = Convert.ToInt32(Console.ReadLine());
            if(year > 2021) return;
            int n = 2021 -year + 1;
            for(int i = 0; i < n; i++){
                string call = "https://openexchangerates.org/api/historical/" + year.ToString() + "-01-01.json?app_id=72a8ed46e61f49c09af2017a0c3dd6a5&symbols=PLN,EUR,GBP";
                HttpClient client = new HttpClient();
                string response = await client.GetStringAsync(call);
                Console.WriteLine(response);
                Console.WriteLine(year);
                year++;
            }
        }
    }
}
