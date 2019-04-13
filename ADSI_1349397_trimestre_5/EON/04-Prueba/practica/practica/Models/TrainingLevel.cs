using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace practica.Models
{
    public class TrainingLevel
    {
        [Key]
        [Required(ErrorMessage = "*El campo {0} es obligatorio*")]
        public string trainingLevel { get; set; }
        [Required(ErrorMessage = "*El campo {0} es obligatorio*")]
        public int State { get; set; }
    }
}