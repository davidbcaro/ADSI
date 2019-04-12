using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Proyect
    {
        [Key]
        public int id_Proyect { get; set; }

        [Display(Name = "Code Of Proyect")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Code { get; set; }

        [Display(Name = "Name Of Proyect")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(60, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string  Name { get; set; }

        public bool Status {get; set; }

        public virtual  ICollection<Phase>Phase{ get; set; }
    }
}