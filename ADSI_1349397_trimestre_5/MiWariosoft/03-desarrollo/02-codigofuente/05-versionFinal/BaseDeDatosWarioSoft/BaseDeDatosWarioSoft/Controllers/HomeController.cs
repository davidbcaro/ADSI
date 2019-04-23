using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BaseDeDatosWarioSoft.Controllers
{
    public class HomeController : Controller
    {
       
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult About()
        {
            ViewBag.Message = "Gestion de horarios(WARIOSFOT)";

            return View();
        }
        public ActionResult Contact()
        {
            ViewBag.Message = "WARIOSFOT";

            return View();
        }
    }
}