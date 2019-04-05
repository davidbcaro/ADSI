using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class Document
    {
        [Key]
        [Column(Order = 9)]
        public int IDDocument { get; set; }
        [StringLength(10)]
        [Display(Name = "Documento")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string documento { get; set; }
        [StringLength(25)]
        [Display(Name = "Name")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string name { get; set; }
        [Display(Name = "State")]
        public Boolean state { get; set; }





    }
}