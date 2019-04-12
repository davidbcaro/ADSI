using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Phase
    {
        [Key]
        public int id_Phase { get; set; }

        [Display(Name = "Name Phase")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(30, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string  name_Phase { get; set; }

        public bool Status{get; set; }

        [NotMapped]
        public string FullPhase{ get { return string.Format("{0} - {1} - {2}", name_Phase, proyect.Code,proyect.Name); } }

        public int id_Proyect { get; set; }
        public virtual Proyect proyect { get; set; }
    }
}