using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace practica.Models
{
    public class User
    {


        [Required (ErrorMessage = "campo obligatorio")  ]
        public string IdDocument { get; set; }
        [Key]
        [Required(ErrorMessage = "campo obligatorio")]
        public int Docuemt { get; set; }
        [Required(ErrorMessage = "campo obligatorio")]
        public string Name { get; set; }
        [Required(ErrorMessage = "campo obligatorio")]
        public string Apellido { get; set; }
        [Required(ErrorMessage = "campo obligatorio")]
        public string Correo { get; set; }
     
    }
}