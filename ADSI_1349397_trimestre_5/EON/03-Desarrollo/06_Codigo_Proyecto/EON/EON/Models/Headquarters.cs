using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Headquarters
    {
        [Key]
        [Display(Name = "idHeadquarters")]
        public int id_Headquarters { get; set; }

        [Display(Name = "nameHeadquarters")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string name_Headquarters { get; set; }

        [Display(Name = "Address")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(45, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of {2} characters", MinimumLength = 1)]
        public string Address { get; set; }

        [Display(Name = "Status")]
        public bool State { get; set; }

        public virtual ICollection<Ambience> Ambiences { get; set; }
    }
}