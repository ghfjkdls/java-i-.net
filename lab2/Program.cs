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
            string call = "https://openexchangerates.org/api/latest.json?app_id=72a8ed46e61f49c09af2017a0c3dd6a5&symbols=PLN,EUR,GBP";
            HttpClient client = new HttpClient();
            string response = await client.GetStringAsync(call);


            Console.WriteLine(response);
        }
    }
}
