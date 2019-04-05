using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class LinkUp
    {
        [Key]
        [Column(Order = 14)]
        public int IDLinkUp { get; set; }
        [Display(Name = "TypeLink")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        public string typeLink { get; set; }
        [Display(Name = "Hours")]
        [Required(ErrorMessage = "El campo {0} es obligatorio")]
        [DataType(DataType.Time)]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = ("{0:HH:mm}"))]
        public DateTime Hours { get; set; }
        [Display(Name = "State")]
        public bool state { get; set; }
        

    }
}